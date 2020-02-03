package com.example.youcantrunawayjon

import android.R.attr.button
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mBoardView: BoardView
    private lateinit var mGameManager: GameManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        mGameManager = GameManager()
        mBoardView = findViewById<View>(R.id.board) as BoardView
        mBoardView.setGame(mGameManager)

        val downButton: Button = findViewById(R.id.down_button)
        val rightButton: Button = findViewById(R.id.right_button)
        val resetButton: Button = findViewById(R.id.reset_button)

        downButton.setOnClickListener{
            Toast.makeText(this,"J walks Down", Toast.LENGTH_SHORT).show()
            mGameManager.setMove(GameManager.J_PLAYER, mGameManager.getJCurrentPosition()!! + 3)

            mBoardView.invalidate()
        }

        rightButton.setOnClickListener{
            Toast.makeText(this,"J walks Right", Toast.LENGTH_SHORT).show()
            mGameManager.setMove(GameManager.J_PLAYER, mGameManager.getJCurrentPosition()!! + 1)
            mBoardView.invalidate()
        }

        resetButton.setOnClickListener{
            Toast.makeText(this,"Board reset", Toast.LENGTH_SHORT).show()
            mGameManager.resetBoard()
            mBoardView.invalidate()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
