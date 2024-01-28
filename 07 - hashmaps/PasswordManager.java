package assn07;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "password321";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }


    @Override
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % _passwords.length;

        Account<K, V> current = _passwords[index];

        if (current == null) {
            _passwords[index] = new Account<>(key, value);
            return;
        }
        else {
            while (current.getNext() != null && (!current.getWebsite().equals(key))) {
                current = current.getNext();
            }
            if (current.getWebsite().equals(key)) {
                current.setPassword(value);
            }
            else {
                Account<K, V> prev = new Account(key, value);
                current.setNext(prev);
            }
        }


    }

    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode()) % _passwords.length;
        if (_passwords[index] == null) {
            return null;
        }

        Account<K, V> current = _passwords[index];


        if (current.getWebsite().equals(key)) {
            return current.getPassword();
        }
        else {
            while (current != null) {
                if (current.getWebsite().equals(key)) {
                    return current.getPassword(); }
                else {
                    current = current.getNext();

                }
            }

        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < _passwords.length; i++) {
            Account<K, V> current = _passwords[i];
            while (current != null) {
                current = current.getNext();
                count += 1;
            }}

        return count;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySett = new HashSet<>();

        for (int i = 0; i < _passwords.length; i++) {
            Account<K, V> current = _passwords[i];
            while (current != null) {
                keySett.add(current.getWebsite());
                current = current.getNext();
            }}

        return keySett;
    }

    @Override
    public V remove(K key) {
        int i = key.hashCode() % _passwords.length;
        if (i < 0) {
            i += _passwords.length;
        }

        Account<K, V> current = _passwords[i];
        Account<K, V> prev = null;


        while (current != null) {
            if (current.getWebsite().equals(key)) {
                if (prev == null) {
                    _passwords[i] = current.getNext();}
                else {
                    prev.setNext(current.getNext());
                }
                return current.getPassword();
                }
                prev = current;
                current = current.getNext();
            }

        return null;
    }

    @Override
    public List<K> checkDuplicate(V value) {
        List<K> keyMatch = new ArrayList<K>();
        for (int i = 0; i < _passwords.length; i++) {
            Account<K, V> current = _passwords[i];
            while (current != null) {
                if (current.getPassword().equals(value)) {
                    keyMatch.add(current.getWebsite()); }
                current = current.getNext();
            }
        }


        return keyMatch;
    }


    @Override
    public boolean checkMasterPassword(String enteredPassword) {

        return enteredPassword.equals(MASTER_PASSWORD);
    }


    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


    public Account[] getPasswords() {
        return _passwords;
    }
}
