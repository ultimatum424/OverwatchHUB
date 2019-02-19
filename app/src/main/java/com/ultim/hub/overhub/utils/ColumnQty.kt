package com.ultim.hub.overhub.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.View


class ColumnQty(context: Context, viewId: Int) {

    private var width: Int
    private var height: Int
    private var remaining: Int = 0
    private var displayMetrics: DisplayMetrics

    var numberOfColumns: Int = 0
        get() = calculateNoOfColumns()
    var spacing: Int = 0
        get() = calculateSpacing()

    init {
        val view = View.inflate(context, viewId, null)
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        width = view.measuredWidth
        height = view.measuredHeight
        displayMetrics = context.getResources().displayMetrics
    }

    private fun calculateNoOfColumns(): Int {
        var numberOfColumns = displayMetrics.widthPixels / width
        remaining = displayMetrics.widthPixels - (numberOfColumns * width)
        if (remaining / (2 * numberOfColumns) < 15) {
            numberOfColumns--
            remaining = displayMetrics.widthPixels - (numberOfColumns * width);
        }
        return numberOfColumns
    }

    private fun calculateSpacing(): Int{
        return remaining / (2 * numberOfColumns)

    }


}