package sebinduke.tictactoe;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String s1,s2;
    int arr[][]=new int[3][3];
    Button b[][]=new Button[3][3];
    Button res;
    boolean bo;
    int i,j;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1="Player 1s move";
        s2="Player 2s move";
        bo=true;
        tv=(TextView)findViewById(R.id.text);

        b[0][0]=(Button)findViewById(R.id.b00);
        b[0][1]=(Button)findViewById(R.id.b01);
        b[0][2]=(Button)findViewById(R.id.b02);
        b[1][0]=(Button)findViewById(R.id.b10);
        b[1][1]=(Button)findViewById(R.id.b11);
        b[1][2]=(Button)findViewById(R.id.b12);
        b[2][0]=(Button)findViewById(R.id.b20);
        b[2][1]=(Button)findViewById(R.id.b21);
        b[2][2]=(Button)findViewById(R.id.b22);
        res=(Button)findViewById(R.id.res);

        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                b[i][j].setOnClickListener(this);
            }
        }
        res.setOnClickListener(this);
    }

    private String getStr()
    {
        if(bo)
            return "X";
        else
            return "O";
    }

    private String getS()
    {
        if(bo)
            return s2;
        else
            return s1;
    }

    private int checkVictory(int i,int j)
    {
        if((arr[0][0]==arr[1][1]  && arr[0][0]==arr[2][2]) || (arr[0][2]==arr[1][1]  && arr[1][1]==arr[2][0]))
        {
            if(arr[1][1]==1)
                return 1;
            else if(arr[1][1]==2)
                return 2;
        }
        if((arr[i][j]==arr[0][j] && arr[i][j]==arr[1][j] && arr[i][j]==arr[2][j]) || (arr[i][j]==arr[i][0]  && arr[i][j]==arr[i][1]  && arr[i][j]==arr[i][2]))
        {
            if(arr[i][j]==1)
                return 1;
            else return 2;
        }

        return 0;
    }

    private void endGame()
    {
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                b[i][j].setEnabled(false);
            }
        }
    }

    @Override
    public void onClick(View v)
    {
        i=3;j=3;
        switch (v.getId())
        {
            case R.id.b00:
                i=0;j=0;
                break;
            case R.id.b01:
                i=0;j=1;
                break;
            case R.id.b02:
                i=0;j=2;
                break;
            case R.id.b10:
                i=1;j=0;
                break;
            case R.id.b11:
                i=1;j=1;
                break;
            case R.id.b12:
                i=1;j=2;
                break;
            case R.id.b20:
                i=2;j=0;
                break;
            case R.id.b21:
                i=2;j=1;
                break;
            case R.id.b22:
                i=2;j=2;
                break;
            case R.id.res:
                for(i=0;i<3;i++)
                {
                    for(j=0;j<3;j++)
                    {
                        b[i][j].setText("");
                        b[i][j].setEnabled(true);
                        arr[i][j]=0;
                    }
                }
                tv.setText(s1);
                bo=true;
                break;
            default:
                break;
        }

        if(i!=3) {
            b[i][j].setText(getStr());
            b[i][j].setEnabled(false);
            tv.setText(getS());

            if (bo)
                arr[i][j] = 1;
            else
                arr[i][j] = 2;

            bo = !bo;


            int ch = checkVictory(i, j);

            if (ch == 1) {
                tv.setText("Player ONE has won the game");
                endGame();
            } else if (ch == 2) {
                tv.setText("Player TWO has won the game");
                endGame();
            }
        }
    }
}