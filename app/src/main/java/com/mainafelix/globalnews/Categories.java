package com.mainafelix.globalnews;

public class Categories {
        public String getCategory;
        private String category;
        private String categoryImageUrl;
        public Categories(String category, String categoryImageUrl) {
            this.category = category;
            this.categoryImageUrl = categoryImageUrl;
        }

        public String getCategory() {
            return category;
        }

        public String getGetCategory() {
            return getCategory;
        }

        public void setGetCategory(String getCategory) {
            this.getCategory = getCategory;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCategoryImageUrl() {
            return categoryImageUrl;
        }

        public void setCategoryImageUrl(String categoryImageUrl) {
            this.categoryImageUrl = categoryImageUrl;
        }
    }


