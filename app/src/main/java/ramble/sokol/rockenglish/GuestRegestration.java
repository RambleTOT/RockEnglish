package ramble.sokol.rockenglish;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GuestRegestration extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    EditText editGuest;
    TextView dialogText, textNickGuest;
    Dialog dialog;
    Button yes, no, buttonRegGuest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        editGuest = findViewById(R.id.editGuest);
        editGuest.setOnFocusChangeListener(this);
        buttonRegGuest = findViewById(R.id.buttonRegGuest);
        buttonRegGuest.setOnClickListener(this);
        textNickGuest = findViewById(R.id.textNickGuest);
    }

    @Override
    public void onClick(View view) {
        if (editGuest.getText().toString().replaceAll(" ", "").equalsIgnoreCase("")){
            textNickGuest.setVisibility(View.VISIBLE);
        }else{
            dialog();
        }
    }

    @Override
    public void onBackPressed() {
            Intent intent = new Intent(GuestRegestration.this, FirstActivity.class);
            startActivity(intent);
            finish();
    }

    private void dialog(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show();
        dialogText = dialog.findViewById(R.id.textDialogConfirm);
        dialogText.setText(R.string.confirmGuest);
        yes = dialog.findViewById(R.id.yes);
        no = dialog.findViewById(R.id.no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuestRegestration.this, SecondActivity.class);
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
    public void onFocusChange(View view, boolean b) {
        textNickGuest.setVisibility(View.GONE);
    }
}