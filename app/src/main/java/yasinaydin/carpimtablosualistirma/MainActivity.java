package yasinaydin.carpimtablosualistirma;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static yasinaydin.carpimtablosualistirma.Main2Activity.a;
import static yasinaydin.carpimtablosualistirma.Main2Activity.b;
import static yasinaydin.carpimtablosualistirma.Main2Activity.h;

public class MainActivity extends AppCompatActivity {
    Button baslama;
    TextView dogru;
    TextView yanlis;
    TextView alis;
    TextView basla;
    TextView sure;
    double surre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baslama=(Button)findViewById(R.id.button1);
        dogru=(TextView)findViewById(R.id.textView2);
        yanlis=(TextView)findViewById(R.id.textView3);
        basla=(TextView)findViewById(R.id.textView1);
        alis=(TextView)findViewById(R.id.textView4);
        sure=(TextView)findViewById(R.id.textView5);
        baslama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ac=new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(ac,2);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==2){
            if(resultCode== Activity.RESULT_OK){
                surre=h/1000.0;
                alis.setVisibility(View.VISIBLE);
                dogru.setText("Doğru Sayısı : "+a);
                yanlis.setText("Yanlış Sayısı : "+b);
                sure.setText("Toplam Süre : "+surre);
                baslama.setText("Devam Et");
                basla.setText("Haydi, Alıştırmaya Devam Edelim!");

            }
        }
    }

}
