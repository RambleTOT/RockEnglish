package ramble.sokol.rockenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Regstration extends AppCompatActivity implements View.OnClickListener {

    EditText editReg;
    TextView textEntry;
    Dialog dialog;
    Button yes,no, buttonRegestration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regstration);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        editReg = findViewById(R.id.editReg);
        buttonRegestration = findViewById(R.id.buttonRegestration);
        textEntry = findViewById(R.id.textEntry);
        buttonRegestration.setOnClickListener(this);
        textEntry.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonRegestration:
                dialog();
                break;

            case R.id.textEntry:
                Intent intent = new Intent(Regstration.this, Entry.class);
                startActivity(intent);
                finish();
                break;
        }

    }

    private void dialog(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();
        yes = dialog.findViewById(R.id.yes);
        no = dialog.findViewById(R.id.no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Regstration.this, SecondActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Regstration.this, FirstActivity.class);
        startActivity(intent);
        finish();
    }

}