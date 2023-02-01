package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private final String filePath;

    public FileKV(String filepath, Map<String, String> initValues) {
        this.filePath = filepath;
        initValues.forEach(this::set);
    }

    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(filePath);
        Map<String, String> data = Utils.unserialize(content);
        data.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(filePath);
        Map<String, String> data = Utils.unserialize(content);
        data.remove(key);
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(filePath);
        Map<String, String> data = Utils.unserialize(content);
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(filePath);
        return Utils.unserialize(content);
    }
}
// END
