package ramble.sokol.rockenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnGuest, btnRegestr;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();

    }

    private void init(){
        btnGuest = findViewById(R.id.buttonGuest);
        btnRegestr = findViewById(R.id.buttonRegestr);
        btnGuest.setOnClickListener(this);
        btnRegestr.setOnClickListener(this);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonGuest:
                intent = new Intent(FirstActivity.this, GuestRegestration.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonRegestr:
                intent = new Intent(FirstActivity.this, Regstration.class);
                startActivity(intent);
                finish();
                break;

        }
    }


}