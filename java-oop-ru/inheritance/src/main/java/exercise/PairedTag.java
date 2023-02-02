package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public class PairedTag extends Tag{
    private final String body;
    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String closingTag = "</" + getName() + ">";
        StringBuilder result = new StringBuilder("<").append(getName());
        if(!getAttributes().isEmpty()) {
            for (Map.Entry<String, String> entry : getAttributes().entrySet()) {
                result.append(" ")
                        .append(entry.getKey())
                        .append("=")
                        .append("\"")
                        .append(entry.getValue())
                        .append("\"");
            }
        }
        result.append(">");
        if(!children.isEmpty()) {
            for (Tag child : children) {
                result.append(child.toString());
            }
        }
        if(!body.equals("")) {
            result.append(body);
        }
        return result.append(closingTag).toString();
    }
}
// END
