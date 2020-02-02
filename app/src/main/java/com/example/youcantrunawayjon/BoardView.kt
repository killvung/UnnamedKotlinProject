package com.example.youcantrunawayjon

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class BoardView : View {
    private lateinit var mPaint: Paint
    private lateinit var mJonBitmap: Bitmap
    private lateinit var mQBitmap: Bitmap
    private val gridLineWidth:Float = 6F

    constructor(context: Context) : super(context, null){
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initialize()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize()
    }

    private fun initialize() {
        this.mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        this.mJonBitmap = BitmapFactory.decodeResource(resources, R.drawable.j)
        this.mQBitmap = BitmapFactory.decodeResource(resources, R.drawable.q)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val boardWidth:Int = width
        val boardHeight:Int = height

        // Gray line
        mPaint.color = Color.LTGRAY
        mPaint.strokeWidth = gridLineWidth

        // Draws the vertical lines
        val cellWidth = boardWidth / 3
        canvas.drawLine(cellWidth.toFloat(), 0f, cellWidth.toFloat(), boardHeight.toFloat(), mPaint)
        canvas.drawLine(
            cellWidth * 2.toFloat(),
            0f,
            cellWidth * 2.toFloat(),
            boardHeight.toFloat(),
            mPaint
        )

        // Draws the horizontal lines
        canvas.drawLine(0f, cellWidth.toFloat(), boardWidth.toFloat(), cellWidth.toFloat(), mPaint)
        canvas.drawLine(
            0f,
            cellWidth * 2.toFloat(),
            boardWidth.toFloat(),
            cellWidth * 2.toFloat(),
            mPaint
        )
    }
}