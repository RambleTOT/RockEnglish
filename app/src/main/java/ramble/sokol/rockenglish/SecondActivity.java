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
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView btnZero, btnTest, dialogText;
    Intent intent;
    Dialog dialog;
    Button yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        btnTest = findViewById(R.id.buttonTest);
        btnZero = findViewById(R.id.buttonZero);
        btnZero.setOnClickListener(this);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonZero:
                dialog(0);
                break;
            case R.id.buttonTest:
                dialog(1);
                break;
        }
    }

    private void dialog(int i){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();
        dialogText = dialog.findViewById(R.id.textDialogConfirm);
        yes = dialog.findViewById(R.id.yes);
        no = dialog.findViewById(R.id.no);
        if (i == 0){
            dialogText.setTextSize(20);
            dialogText.setText(R.string.confirmSecond);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(SecondActivity.this, MainMenu.class);
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
        }else if (i == 1){
            dialogText.setText(R.string.confirmTest);
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(SecondActivity.this, Test.class);
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
    }

}