package rasberrymuffine.homecaresystemapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MAIN = 1001;
    public static final int REQUEST_CODE_JOIN = 1002;

    private EditText inputSerialNum;
    private Button okButton;
    private Button joinButton;
    private String serialNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputSerialNum = (EditText)findViewById(R.id.idEdit);
        okButton = (Button)findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serialNum = inputSerialNum.getText().toString();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("serialNum",serialNum);

                startActivityForResult(intent, REQUEST_CODE_MAIN);

                finish();
            }
        });
        joinButton = (Button)findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),JoinActivity.class);

                startActivityForResult(intent, REQUEST_CODE_JOIN);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
    }

}