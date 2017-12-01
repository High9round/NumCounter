package com.hi9h_9r0und.touch_counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var number=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //회전시 데이터 불러오기
        if(savedInstanceState != null)
        {
            number=savedInstanceState.getInt("num")
        }

        //숫자 초기화
        set_text()

        //버튼 초기화
        button_count.setOnClickListener{
            number++
            set_text()
        }

        button_reset.setOnClickListener {
            number=0
            set_text()
            Toast.makeText(this, "Counter RESET", Toast.LENGTH_SHORT).show()
        }
    }

    //회전시 데이터 백업
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("num", number)
    }

    fun set_text()
    {
        textView_number.text=number.toString()
    }
}
