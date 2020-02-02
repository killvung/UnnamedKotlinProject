package com.example.youcantrunawayjon

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class BoardView : View {
    private lateinit var mPaint: Paint
    private lateinit var mJonBitmap: Bitmap
    private lateinit var mQBitmap: Bitmap
    private lateinit var mGameManager: GameManager
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

    fun getBoardCellWidth(): Int { return width / 3 }

    fun getBoardCellHeight(): Int { return height / 3 }

    fun setGame(gameManager: GameManager){ mGameManager = gameManager }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val boardWidth:Int = width
        val boardHeight:Int = height

        mPaint.color = Color.LTGRAY
        mPaint.strokeWidth = gridLineWidth

        val cellWidth = boardWidth / 3
        drawVerticalLines(canvas, boardWidth, boardHeight)
        drawHorizontalLines(canvas, boardWidth, cellWidth)

        for (i in 0 until GameManager.BOARD_SIZE) {
            val col = i % 3
            val row = i / 3
            // Define the boundaries of a destination rectangle for the image
            val xTopLeft = col * cellWidth
            val yTopLeft = row * cellWidth
            val xBottomRight = xTopLeft + cellWidth
            val yBottomRight = yTopLeft + cellWidth

            if(mGameManager.getBoardOccupant(i) == GameManager.J_PLAYER){
                canvas.drawBitmap(
                    mJonBitmap,
                    null,
                    Rect(xTopLeft, yTopLeft, xBottomRight, yBottomRight),  // dest
                    null
                )
            } else if(mGameManager.getBoardOccupant(i) == GameManager.Q_PLAYER){
                canvas.drawBitmap(
                    mQBitmap,
                    null,  // src
                    Rect(xTopLeft, yTopLeft, xBottomRight, yBottomRight),  // dest
                    null
                )
            }
        }
    }

    private fun drawHorizontalLines(canvas: Canvas, boardWidth:Int, cellWidth: Int){
        canvas.drawLine(0f, cellWidth.toFloat(), boardWidth.toFloat(), cellWidth.toFloat(), mPaint)
        canvas.drawLine(
            0f,
            cellWidth * 2.toFloat(),
            boardWidth.toFloat(),
            cellWidth * 2.toFloat(),
            mPaint
        )
    }

    private fun drawVerticalLines(canvas: Canvas, boardWidth: Int, boardHeight: Int) {
        val cellWidth = boardWidth / 3
        canvas.drawLine(cellWidth.toFloat(), 0f, cellWidth.toFloat(), boardHeight.toFloat(), mPaint)
        canvas.drawLine(
            cellWidth * 2.toFloat(),
            0f,
            cellWidth * 2.toFloat(),
            boardHeight.toFloat(),
            mPaint
        )
    }
}