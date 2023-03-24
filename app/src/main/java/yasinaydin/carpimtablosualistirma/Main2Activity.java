package yasinaydin.carpimtablosualistirma;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    static int a,b,c,e,f,g;
    static long h;
    String d;
    EditText cevap;
    Button cevapla;
    TextView soru;
    Random rast;
    TextView sayi;
    Chronometer sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rast=new Random();
        cevap=(EditText)findViewById(R.id.editText1);
        cevapla=(Button)findViewById(R.id.button2);
        soru=(TextView)findViewById(R.id.textView5);
        sayi=(TextView)findViewById(R.id.textView);
        sure=(Chronometer)findViewById(R.id.chronometer);
        a=0;
        b=0;
        c=0;
        e=0;
        sure.start();
        f=rast.nextInt(10)+1;
        g=rast.nextInt(10)+1;
        soru.setText(f+" x "+g+" = ?");
        cevapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c>9){
                    h=SystemClock.elapsedRealtime()-sure.getBase();
                    sure.stop();
                    Intent in=new Intent();
                    setResult(Activity.RESULT_OK,in);
                    finish();
                }
                else {
                    d = String.valueOf(cevap.getText());
                    if (!d.equals("")) {
                        e = Integer.parseInt(d);

                        if (e == (f * g)) {
                            a++;
                            c++;
                            if (c < 10) {
                                f = rast.nextInt(10) + 1;
                                g = rast.nextInt(10) + 1;
                                soru.setText(f + " x " + g + " = ?");
                                cevap.setText("");
                                sayi.setText("Şu An " + (c + 1) + ". Sorudasın.");
                            }
                            else{
                                h=SystemClock.elapsedRealtime()-sure.getBase();
                                sure.stop();
                                Intent in=new Intent();
                                setResult(Activity.RESULT_OK,in);
                                finish();
                            }
                        }
                        else {
                            b++;
                            c++;
                            Toast.makeText(Main2Activity.this, ("Doğru cevap " + (f * g) + " idi."), Toast.LENGTH_LONG).show();
                            if (c < 10) {
                                f = rast.nextInt(10) + 1;
                                g = rast.nextInt(10) + 1;
                                soru.setText(f + " x " + g + " = ?");
                                cevap.setText("");
                                sayi.setText("Şu An " + (c + 1) + ". Sorudasın.");
                            }
                            else{
                                h=SystemClock.elapsedRealtime()-sure.getBase();
                                sure.stop();
                                Intent in=new Intent();
                                setResult(Activity.RESULT_OK,in);
                                finish();
                            }
                        }

                    }
                    else {
                        Toast.makeText(Main2Activity.this,"Lütfen Kutucuğu Boş Bırakma!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
    }
}
