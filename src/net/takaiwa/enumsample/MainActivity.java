package net.takaiwa.enumsample;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispErrorMessage(ResultCode.OK);
            }
        });
        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispErrorMessage(ResultCode.ERROR_FORBIDDEN);
            }
        });
        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispErrorMessage(ResultCode.ERROR_NOTFOUND);
            }
        });
        ((Button)findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispErrorMessage(ResultCode.ERROR_INTERNAL_SERVER);
            }
        });


        Resources resources = this.getResources();

        final Sweets[] values = Sweets.values();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // アイテムを追加します
        for(Sweets value : values) {
            adapter.add(value.getName(resources));
        }
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        // アダプターを設定します
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Resources resources = MainActivity.this.getResources();

                String message = "値段:" + values[position].getPrice(resources);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });
    }

    private void dispErrorMessage(ResultCode result) {

        Resources resources = this.getResources();

        switch(result) {
        // ResultCode型として判定できる↓
        case OK:
            // なにもしない
            break;
        case ERROR_FORBIDDEN:
        case ERROR_NOTFOUND:
        case ERROR_INTERNAL_SERVER:
            // エラーを画面に表示
            String error_message = result.getErrorCode() + ":" + result.getMessage(resources);
            Toast.makeText(this, error_message, Toast.LENGTH_SHORT).show();
            break;
        default:
            Toast.makeText(this, ResultCode.ERROR_UNKNOWN.getMessage(resources), Toast.LENGTH_LONG).show();
            break;
        }
    }

    public ResultCode function() {

        String page_content = null;

        // .....

        if(null == page_content) {
            return ResultCode.ERROR_NOTFOUND;
        }

        return ResultCode.OK;
    }
}
