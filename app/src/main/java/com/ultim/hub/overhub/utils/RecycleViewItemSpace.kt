package com.ultim.hub.overhub.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class RecycleViewItemSpace(private val space: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        if (outRect != null && parent != null) {
            outRect.left = space
            outRect.right = space
            outRect.bottom = space
            if (parent.getChildLayoutPosition(view) == 0) {
               // outRect.top = space;
            } else {
               // outRect.top = 0;
            }
        }
    }

}