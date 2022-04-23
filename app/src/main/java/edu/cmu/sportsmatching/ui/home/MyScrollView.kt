package edu.cmu.sportsmatching.ui.home

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView
import android.view.MotionEvent

class MyScrollView(context: Context?, attrs: AttributeSet?) : ScrollView(context, attrs) {
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        requestDisallowInterceptTouchEvent(true)
        return super.dispatchTouchEvent(ev)
    }
}