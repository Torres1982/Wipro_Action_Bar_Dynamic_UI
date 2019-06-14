package com.wipro.wipro_action_bar_add_views;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MenuItem itemButton, itemEditText, itemTextView;
    LinearLayout childLinearLayout;
    LinearLayout.LayoutParams param1, param2;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemButton = findViewById(R.id.item_button);
        itemEditText = findViewById(R.id.item_edit_text);
        itemTextView = findViewById(R.id.item_text_view);
        scrollView = findViewById(R.id.scroll_view);
        param1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        param2 = new LinearLayout.LayoutParams(400, 200);
        param2.topMargin = 40;
        scrollView = new ScrollView(this);
        childLinearLayout = new LinearLayout(MainActivity.this);

        setChildLinearLayout(childLinearLayout);
        setScrollView(scrollView);
        this.setContentView(scrollView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_button:
                Button button = new Button(this);
                button.setLayoutParams(param2);
                button.setText(R.string.button);
                button.setTextColor(Color.YELLOW);
                button.setBackgroundColor(Color.BLUE);
                button.setGravity(Gravity.CENTER);
                childLinearLayout.addView(button);
                displayToastMessage("Button Menu Item Clicked!");
            break;
            case R.id.item_edit_text:
                EditText editText = new EditText(this);
                editText.setLayoutParams(param2);
                editText.setText(R.string.edit_text);
                editText.setGravity(Gravity.CENTER);
                childLinearLayout.addView(editText);
                displayToastMessage("Edit Text Menu Item Clicked!");
            break;
            case R.id.item_text_view:
                TextView textView = new TextView(this);
                textView.setLayoutParams(param2);
                textView.setText(R.string.text_view);
                textView.setGravity(Gravity.CENTER);
                childLinearLayout.addView(textView);
                displayToastMessage("Text View Menu Item Clicked!");
            break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    // Display Toast Message when the new View is added
    private void displayToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Set Up the Main Linear Layout
    private void setChildLinearLayout(LinearLayout layout) {
        layout.setLayoutParams(param1);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);
    }

    // Set Up the Scroll View
    private void setScrollView(ScrollView scroll) {
        scroll.setLayoutParams(param1);
        scroll.addView(childLinearLayout);
    }
}