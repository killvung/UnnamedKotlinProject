package com.example.youcantrunawayjon

class TicTacToeGame {
    private var mBoard: CharArray

    companion object {
        const val BOARD_SIZE:Int = 9
        const val J_PLAYER:Char = 'X'
        const val Q_PLAYER:Char = 'O'
        const val OPEN_SPOT:Char = ' '
    }

    fun getBoardOccupant(i: Int): Char {
        return mBoard[i]
    }

    init {
        mBoard = CharArray(BOARD_SIZE)
        clearBoard()
    }

    fun clearBoard() {
        for (i in mBoard.indices) mBoard[i] = OPEN_SPOT
        mBoard[0] = J_PLAYER
        mBoard[2] = Q_PLAYER
    }

}