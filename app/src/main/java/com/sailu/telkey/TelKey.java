package com.sailu.telkey;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.Keyboard.Key;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saileshrachabathuni on 3/2/16.
 */
public class TelKey extends InputMethodService
    implements KeyboardView.OnKeyboardActionListener{

    private KeyboardView kv;
    private Keyboard keyboard;
    private Keyboard specialKeyboard;
    private TransEngine engine;
    private boolean showingSpecialKeyboard;
    private Key textModeKey;
    private boolean textModeTelugu;

    private boolean caps = false;

    @Override
    public View onCreateInputView() {
        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        specialKeyboard = new Keyboard(this, R.xml.specials);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        engine = new TransEngine();
        showingSpecialKeyboard = false;
        textModeKey = getTextModeKey(keyboard);
        textModeKey.on = true;
        textModeTelugu = true;
        return kv;
    }

    private Key getTextModeKey(Keyboard keybd) {
        List<Key> keys = keybd.getKeys();
        for (Key key: keys) {
            if (key.codes[0] == 1000) {
                return key;
            }
        }

        return null;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        Trans t;

        //playClick(primaryCode);
        CharSequence chars = ic.getTextBeforeCursor(2, 0);
        char pchar, ppchar;

        if (chars == null || chars.length() == 0) {
            pchar = TransEngine.NULL_CHAR;
            ppchar = TransEngine.NULL_CHAR;
        }
        else if (chars.length() == 1) {
            ppchar = TransEngine.NULL_CHAR;
            pchar = chars.charAt(0);
        }
        else {
            ppchar = chars.charAt(0);
            pchar = chars.charAt(1);
        }

        switch(primaryCode){
            case 1000:
                textModeTelugu = !textModeTelugu;
                textModeKey.on = textModeTelugu;
                kv.invalidateAllKeys();
                break;
            case 64:
                kv.setKeyboard(specialKeyboard);
                kv.setOnKeyboardActionListener(this);
                showingSpecialKeyboard = true;
                break;

            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                break;

            case Keyboard.KEYCODE_DONE:
                if (showingSpecialKeyboard) {
                    kv.setKeyboard(keyboard);
                    kv.setOnKeyboardActionListener(this);
                    showingSpecialKeyboard = false;
                }
                else {
                    ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                }
                break;

            case Keyboard.KEYCODE_DELETE :
                // Deliberate fallthrough
            default:
                String inchar;

                if (primaryCode == Keyboard.KEYCODE_DELETE) {
                    inchar = "BS";
                }
                else {
                    char code = (char)primaryCode;
                    if (caps) {
                        if (Character.isLetter(code)) {
                            code = Character.toUpperCase(code);
                        }
                        caps = false;
                        keyboard.setShifted(false);
                        kv.invalidateAllKeys();
                    }

                    inchar = String.valueOf(code);
                }

                String outStr;
                int replaceChars;

                if (!textModeTelugu) {
                    if (primaryCode == Keyboard.KEYCODE_DELETE) {
                        outStr = "";
                        replaceChars = 1;
                    }
                    else {
                        outStr = inchar;
                        replaceChars = 0;
                    }
                }
                else {
                    t = engine.get(inchar, ppchar, pchar);

                    if (t != null) {
                        System.out.println("Found transition: [" + t.outputStr + "] [" + t.replaceChars + "]");
                        outStr = t.outputStr;
                        replaceChars = t.replaceChars;
                    } else {
                        System.out.println("No transition");
                        outStr = inchar;
                        replaceChars = 0;
                    }
                }

                if (replaceChars >  0) {
                    ic.deleteSurroundingText(replaceChars, 0);
                }

                ic.commitText(outStr, outStr.length());
        }
    }

    @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }

    private void playClick(int keyCode){
        AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
        switch(keyCode){
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case Keyboard.KEYCODE_DONE:
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default: am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
        }
    }

}
