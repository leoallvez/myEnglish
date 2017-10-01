package com.br.myenglish.activity;

import java.util.List;
import android.util.Log;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import com.br.myenglish.R;
import java.util.ArrayList;
import android.app.Activity;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.LinearLayout;
import com.br.myenglish.model.Phrase;

public class MainActivity extends Activity {

    private TextView textViewPhrase;
    private TextView textViewAuthor;
    private LinearLayout linearLayout;
    private List<Phrase> phrases;
    private String[] colors;
    private String lastPhrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phrases = new ArrayList<Phrase>();
        textViewPhrase = (TextView) findViewById(R.id.texViewPhraseId);
        textViewAuthor = (TextView) findViewById(R.id.texViewAuthorId);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutId);

        getAllPhrases();
        colors = getColors();
        selectColor();
        selectPhrase();
        lastPhrase = "";
    }

    public void onClick(View v) {
        selectColor();
        selectPhrase();
    }

    private void selectPhrase() {
        Random random = new Random();
        int randomNumber = random.nextInt(phrases.size());
        Phrase phrase = phrases.get(randomNumber);

        while(phrase.getText().equals(lastPhrase)) {
            randomNumber = random.nextInt(phrases.size());
            phrase = phrases.get(randomNumber);
        }
        lastPhrase = phrase.getText();
        textViewPhrase.setText(phrase.getText());
        textViewAuthor.setText("("+phrase.getAuthor()+")");
    }

    private void selectColor(){
        Random random = new Random();
        int randomNumber  = random.nextInt(colors.length);
        linearLayout.setBackgroundColor(Color.parseColor(colors[randomNumber]));

        Log.d("myColor", colors[randomNumber]);
    }

    private String[] getColors() {
        String[] colors = {
                "#1565C0",
                "#00695C",
                "#00E676",
                "#FF6D00",
                "#FF6D00",
                "#1B5E20",
                "#D84315",
                "#E64A19",
                "#FF3D00",
                "#8BC34A",
                "#01579B",
                "#673AB7",
                "#D50000",
                "#9C27B0",
                "#6A1B9A",
                "#880E4F",
                "#AD1457",
                "#B71C1C",
                "#004D40",
                "#512DA8",
        };
        return colors;
    }

    private void getAllPhrases() {

        phrases.add(new Phrase(
                "Let me give you some advice, bastard. Never forget what you are. The rest of the " +
                        "world will not. Wear it like armour, and it can never be used to hurt you.",
                "Tyrion Lannister"
        ));

        phrases.add(new Phrase(
                "The man who passes the sentence should swing the sword.",
                "Ned Stark"
        ));

        phrases.add(new Phrase(
                "When you play the game of thrones, you win or you die. There is no middle ground.",
                "Cersei Lannister"
        ));

        phrases.add(new Phrase(
                "There is only one god, and his name is Death. And there is only one thing we say " +
                        "to Death: 'Not today.",
                "Syrio Forel"
        ));

        phrases.add(new Phrase(
                "Anyone can be killed.",
                "Arya Stark"
        ));

        phrases.add(new Phrase(
                "All men must die, but we are not men.",
                "Daenerys Targaryen"
        ));

        phrases.add(new Phrase(
                "If you think this has a happy ending, you haven't been paying attention.",
                "Ramsay Bolton"
        ));

        phrases.add(new Phrase(
                "Any man who must say 'I am the king' is no true king",
                "Tywin Lannister"
        ));

        phrases.add(new Phrase(
                "Money buys a man's silence for a time. A bolt in the heart buys it forever.",
                "Littlefinger"
        ));

        phrases.add(new Phrase(
                "If you ever call me sister again, I'll have you strangled in your sleep.",
                "Cersei Lannister"
        ));

        phrases.add(new Phrase(
                "A dragon is not a slave.",
                "Daenerys Targaryen"
        ));

        phrases.add(new Phrase(
                "You’re mine. Mine, as I’m yours. And if we die, we die. All men must die, Jon Snow. But first we’ll live.",
                "Ygritte"
        ));
    }
}