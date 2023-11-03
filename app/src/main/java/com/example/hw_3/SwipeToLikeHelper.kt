package com.example.hw_3

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3.decoration.dp

fun RecyclerView.swipeToLike(likeAction: (Int) -> Unit) {
    ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END){
        val rectangleLength = 97.dp
        val maxScroll = 80.dp
        val image = BitmapFactory.decodeResource(resources, R.drawable.ic_heart)


        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (viewHolder is JobListAdapter.JobViewHolder) {
                context.vibratePhone()
                likeAction.invoke(viewHolder.adapterPosition)
            }
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            if (viewHolder is JobListAdapter.JobViewHolder &&
                actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                with(viewHolder.itemView) {
                    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                    val scrollOfSet = dX.toInt()

                    if (scrollOfSet > 1){
                        paint.color = ContextCompat.getColor(context, R.color.blue)
                        val back = RectF(
                            left.toFloat(),
                            top.toFloat(),
                            left.toFloat() + rectangleLength,
                            bottom.toFloat(),
                        )
                        c.drawRect(back, paint)
                    }

                    if (scrollOfSet < maxScroll) {
                        super.onChildDraw(c, recyclerView, viewHolder, scrollOfSet.toFloat(), dY, actionState, isCurrentlyActive)
                    }

                    if (scrollOfSet > 50.dp ) {
                        val iconRect = RectF(
                            left.toFloat() + 30.dp,
                            top.toFloat() + 28.dp,
                            left.toFloat() + 50.dp,
                            bottom.toFloat() - 30.dp
                        )
                        c.drawBitmap(image, null, iconRect, paint)
                    }

                }
            }
        }

    }).attachToRecyclerView(this)
}

fun Context.vibratePhone(){
    val vibration = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26){
        vibration.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibration.vibrate(100)
    }
}