package com.jobrecommendation.job.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;

// fields from the Github Response
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Item {

    private String id;
    private String title;
    private String location;
    private String companyLogo;
    private String url;
    private String description;
    private Set<String> keywords;
    //code - generate
    private boolean favorite;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("company_logo")
    public String getCompanyLogo() {
        return companyLogo;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {

        this.favorite = favorite;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(title, item.title) &&
                Objects.equals(location, item.location) &&
                Objects.equals(companyLogo, item.companyLogo) &&
                Objects.equals(url, item.url) &&
                Objects.equals(description, item.description) &&
                Objects.equals(keywords, item.keywords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, location, companyLogo, url, description, keywords);
    }

    @Override
    public String toString() {
        return "item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", companyLogo='" + companyLogo + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", keywords=" + keywords +
                ", favorite=" + favorite +
                '}';
    }

    public static class Builder{
        private String id;
        private String title;
        private String location;
        private String companyLogo;
        private String url;
        private String description;
        private Set<String> keywords;
        private boolean favorite;

        public Builder favorite(Boolean favorite) {
            this.favorite = favorite;
            return this;
            }


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder companyLogo(String companyLogo) {
            this.companyLogo = companyLogo;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder keywords(Set<String> keywords) {
            this.keywords = keywords;
            return this;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return favorite == builder.favorite &&
                    Objects.equals(id, builder.id) &&
                    Objects.equals(title, builder.title) &&
                    Objects.equals(location, builder.location) &&
                    Objects.equals(companyLogo, builder.companyLogo) &&
                    Objects.equals(url, builder.url) &&
                    Objects.equals(description, builder.description) &&
                    Objects.equals(keywords, builder.keywords);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, title, location, companyLogo, url, description, keywords, favorite);
        }



        public Item build() {
            Item item = new Item();
            item.id = id;
            item.title = title;
            item.location = location;
            item.companyLogo = companyLogo;
            item.url = url;
            item.description = description;
            item.keywords = keywords;
            item.favorite = favorite;
            return item;
        }
    }
}
