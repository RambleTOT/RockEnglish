package ramble.sokol.rockenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Entry extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    Button btnEntry;
    EditText emailAddressEntry, passwordEntry;
    TextView entryPass, entryMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init(){
        btnEntry = findViewById(R.id.buttonEntry);
        btnEntry.setOnClickListener(this);
        emailAddressEntry = findViewById(R.id.editTextEmailAddressEntry);
        passwordEntry = findViewById(R.id.editTextPasswordEntry);
        emailAddressEntry.setOnFocusChangeListener(this);
        passwordEntry.setOnFocusChangeListener(this);
        entryPass = findViewById(R.id.textEntryPass);
        entryMail = findViewById(R.id.textEntryMail);
    }

    @Override
    public void onClick(View view) {
        if(emailAddressEntry.getText().toString().replaceAll(" ", "").equalsIgnoreCase("") &&
                passwordEntry.getText().toString().replaceAll(" ", "").equalsIgnoreCase("")){
            entryMail.setVisibility(View.VISIBLE);
            entryPass.setVisibility(View.VISIBLE);
        }
        else if (passwordEntry.getText().toString().replaceAll(" ", "").equalsIgnoreCase("")){
            entryPass.setVisibility(View.VISIBLE);
        }else if (emailAddressEntry.getText().toString().replaceAll(" ", "").equalsIgnoreCase("")){
            entryMail.setVisibility(View.VISIBLE);
        }else{
            Intent intent = new Intent(Entry.this, MainMenu.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Entry.this, Regstration.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()){
            case R.id.editTextEmailAddressEntry:
                entryMail.setVisibility(View.GONE);
                break;
            case R.id.editTextPasswordEntry:
                entryPass.setVisibility(View.GONE);
                break;
        }
    }
}