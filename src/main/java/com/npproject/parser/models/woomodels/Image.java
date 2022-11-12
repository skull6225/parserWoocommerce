
package com.npproject.parser.models.woomodels;

import java.util.HashMap;
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
    "date_created",
    "date_created_gmt",
    "date_modified",
    "date_modified_gmt",
    "src",
    "name",
    "alt"
})
public class Image {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("date_created")
    private String dateCreated;
    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;
    @JsonProperty("date_modified")
    private String dateModified;
    @JsonProperty("date_modified_gmt")
    private String dateModifiedGmt;
    @JsonProperty("src")
    private String src;
    @JsonProperty("name")
    private String name;
    @JsonProperty("alt")
    private String alt;
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

    @JsonProperty("date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("date_created")
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @JsonProperty("date_created_gmt")
    public String getDateCreatedGmt() {
        return dateCreatedGmt;
    }

    @JsonProperty("date_created_gmt")
    public void setDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    @JsonProperty("date_modified")
    public String getDateModified() {
        return dateModified;
    }

    @JsonProperty("date_modified")
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    @JsonProperty("date_modified_gmt")
    public String getDateModifiedGmt() {
        return dateModifiedGmt;
    }

    @JsonProperty("date_modified_gmt")
    public void setDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
    }

    @JsonProperty("src")
    public String getSrc() {
        return src;
    }

    @JsonProperty("src")
    public void setSrc(String src) {
        this.src = src;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("alt")
    public String getAlt() {
        return alt;
    }

    @JsonProperty("alt")
    public void setAlt(String alt) {
        this.alt = alt;
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
        sb.append(Image.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("dateCreated");
        sb.append('=');
        sb.append(((this.dateCreated == null)?"<null>":this.dateCreated));
        sb.append(',');
        sb.append("dateCreatedGmt");
        sb.append('=');
        sb.append(((this.dateCreatedGmt == null)?"<null>":this.dateCreatedGmt));
        sb.append(',');
        sb.append("dateModified");
        sb.append('=');
        sb.append(((this.dateModified == null)?"<null>":this.dateModified));
        sb.append(',');
        sb.append("dateModifiedGmt");
        sb.append('=');
        sb.append(((this.dateModifiedGmt == null)?"<null>":this.dateModifiedGmt));
        sb.append(',');
        sb.append("src");
        sb.append('=');
        sb.append(((this.src == null)?"<null>":this.src));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("alt");
        sb.append('=');
        sb.append(((this.alt == null)?"<null>":this.alt));
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
        result = ((result* 31)+((this.dateCreatedGmt == null)? 0 :this.dateCreatedGmt.hashCode()));
        result = ((result* 31)+((this.dateCreated == null)? 0 :this.dateCreated.hashCode()));
        result = ((result* 31)+((this.dateModifiedGmt == null)? 0 :this.dateModifiedGmt.hashCode()));
        result = ((result* 31)+((this.src == null)? 0 :this.src.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.alt == null)? 0 :this.alt.hashCode()));
        result = ((result* 31)+((this.dateModified == null)? 0 :this.dateModified.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Image) == false) {
            return false;
        }
        Image rhs = ((Image) other);
        return ((((((((((this.dateCreatedGmt == rhs.dateCreatedGmt)||((this.dateCreatedGmt!= null)&&this.dateCreatedGmt.equals(rhs.dateCreatedGmt)))&&((this.dateCreated == rhs.dateCreated)||((this.dateCreated!= null)&&this.dateCreated.equals(rhs.dateCreated))))&&((this.dateModifiedGmt == rhs.dateModifiedGmt)||((this.dateModifiedGmt!= null)&&this.dateModifiedGmt.equals(rhs.dateModifiedGmt))))&&((this.src == rhs.src)||((this.src!= null)&&this.src.equals(rhs.src))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.alt == rhs.alt)||((this.alt!= null)&&this.alt.equals(rhs.alt))))&&((this.dateModified == rhs.dateModified)||((this.dateModified!= null)&&this.dateModified.equals(rhs.dateModified))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
