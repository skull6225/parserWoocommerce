
package com.npproject.parser.models.woomodels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "position",
    "visible",
    "variation",
    "options"
})
public class Attribute {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("visible")
    private Boolean visible;
    @JsonProperty("variation")
    private Boolean variation;
    @JsonProperty("options")
    private List<String> options = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("visible")
    public Boolean getVisible() {
        return visible;
    }

    @JsonProperty("visible")
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @JsonProperty("variation")
    public Boolean getVariation() {
        return variation;
    }

    @JsonProperty("variation")
    public void setVariation(Boolean variation) {
        this.variation = variation;
    }

    @JsonProperty("options")
    public List<String> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(List<String> options) {
        this.options = options;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Attribute.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("position");
        sb.append('=');
        sb.append(((this.position == null)?"<null>":this.position));
        sb.append(',');
        sb.append("visible");
        sb.append('=');
        sb.append(((this.visible == null)?"<null>":this.visible));
        sb.append(',');
        sb.append("variation");
        sb.append('=');
        sb.append(((this.variation == null)?"<null>":this.variation));
        sb.append(',');
        sb.append("options");
        sb.append('=');
        sb.append(((this.options == null)?"<null>":this.options));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.visible == null)? 0 :this.visible.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.options == null)? 0 :this.options.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.position == null)? 0 :this.position.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.variation == null)? 0 :this.variation.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Attribute) == false) {
            return false;
        }
        Attribute rhs = ((Attribute) other);
        return ((((((((this.visible == rhs.visible)||((this.visible!= null)&&this.visible.equals(rhs.visible)))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.options == rhs.options)||((this.options!= null)&&this.options.equals(rhs.options))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.position == rhs.position)||((this.position!= null)&&this.position.equals(rhs.position))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.variation == rhs.variation)||((this.variation!= null)&&this.variation.equals(rhs.variation))));
    }

}
