package voxterra.voxterra;

/**
 * Created by ethan_000 on 2015-10-24.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class HomeScreenAct extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        Button btnNextScreen = (Button) findViewById(R.id.btn_Relations);

        btnNextScreen.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){
                //Starting new intent
                Intent nextScreen = new Intent(getApplicationContext(), RelationScreenAct.class);

                startActivity(nextScreen);



            }
        });
    }
}