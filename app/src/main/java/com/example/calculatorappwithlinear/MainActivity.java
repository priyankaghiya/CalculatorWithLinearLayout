package com.example.calculatorappwithlinear;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener
{
    EditText et;
    Button b[]=new Button[19];
    int eid[]={R.id.btClear,R.id.btBack,R.id.btPer,
                R.id.bt7,R.id.bt8,R.id.bt9,R.id.btDiv,
            R.id.bt4,R.id.bt5,R.id.bt6,R.id.btMul,
            R.id.bt3,R.id.bt2,R.id.bt1,R.id.btSub,
            R.id.btDot,R.id.btEqual,R.id.bt0,R.id.btAdd,
    };
    int i;
    String number="";
    String op="";
    Float val;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.et);

        for(i=0;i<b.length;i++)
        {
            b[i]=findViewById(eid[i]);
            b[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v)
    {
            Button b=(Button)v;//here v will contain the reference of any of the 19 button click and type casting it into button

            String lab=b.getText().toString();
            if(lab.equals("CLEAR"))
            {
                et.setText(" ");
                number="";
            }
            else if(lab.equals("%"))
            {
                    val=Float.parseFloat(number);
                    op=lab;
                    number="";

            }
            else if(lab.equals("+"))
            {
                val=Float.parseFloat(number);
                op=lab;
                number="";
            }
            else if(lab.equals("-"))
            {
                val=Float.parseFloat(number);
                op=lab;
                number="";
            }
            else if(lab.equals("*"))
            {
                val=Float.parseFloat(number);
                op=lab;
                number="";
            }
            else if(lab.equals("/"))
            {
                val=Float.parseFloat(number);
                op=lab;
                number="";
            }
            else if(lab.equals("."))
            {
                    number=number+".";
            }
            else if(lab.equals("="))
            {
                Float number1=Float.parseFloat(number);
                if(op.equals("%"))
                {
                        int modulo= (int) (val%number1);
                        String m=Integer.toString(modulo);
                        et.setText(m);
                }
                else if(op.equals("*"))
                {
                    int modulo= (int) (val*number1);
                    String m=Integer.toString(modulo);
                    et.setText(m);
                }
                else if(op.equals("/"))
                {
                    String m="";
                    if(number1!=0)
                    {
                        int modulo= (int) (val/number1);
                        m=Integer.toString(modulo);
                    }
                    else
                    {
                         m="ERROR";
                    }
                     et.setText(m);
                }
                else if(op.equals("+"))
                {
                    int modulo= (int) (val+number1);
                    String m=Integer.toString(modulo);
                    et.setText(m);
                }
                else if(op.equals("-"))
                {
                    int modulo= (int) (val-number1);
                    String m=Integer.toString(modulo);
                    et.setText(m);
                }
            }
            else if(b.getId()==R.id.btBack)//as it is an integer we use == (it is for image we compare id as for string it will give null)
            {
                number=number.substring(0,number.length()-1);
                et.setText(number);
            }
            else
            {
                number=number+lab;
                et.setText(number);
            }
    }
}
