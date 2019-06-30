package e.t.navigationdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CheckIp extends AppCompatActivity {

    EditText editText1;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ip);

        editText1=findViewById(R.id.editText1);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findIp();
            }
        });
    }

    public void findIp()
    {
        editText1=findViewById(R.id.editText1);
        textView=findViewById(R.id.textView);

        String ipString=editText1.getText().toString();
        StringTokenizer tokens = new StringTokenizer(ipString, ".");
        boolean ans=false;
        //textView.setText(String.valueOf(a));
        //int a=Integer.parseInt(arr[0]),b=Integer.parseInt(arr[1]),c=Integer.parseInt(arr[2]),d=Integer.parseInt(arr[3]);
        if(tokens.countTokens()==4)
        {
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int c = Integer.parseInt(tokens.nextToken());
            int d = Integer.parseInt(tokens.nextToken());

            if((c<=255&&c>=0)&&(d<=255&&d>=0))
            {
                if(a==10)
                {
                    if(b<=255&&b>=0)
                        ans=true;
                }
                else if(a==172)
                {
                    if(b<=31&&b>=16)
                        ans=true;
                }
                else if(a==192)
                {
                    if(b==168)
                        ans=true;
                }
            }
        }
        if(ans==true)
            textView.setText("This is a public IP ");
        else
            textView.setText("This is a private IP");
    }
}
