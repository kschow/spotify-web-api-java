package com.wrapper.spotify.model_objects.specification;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.wrapper.spotify.model_objects.AbstractModelObject;

/**
 * Retrieve information about
 *     <a href="https://developer.spotify.com/web-api/object-model/#image-object">Image objects</a>
 *     by building instances from this class.
 */
public class Image extends AbstractModelObject {
  private final int height;
  private final String url;
  private final int width;

  private Image(final Image.Builder builder) {
    super(builder);

    this.height = builder.height;
    this.url = builder.url;
    this.width = builder.width;
  }

    /**
     * Get the height of the image in pixels.
     *
     * @return The image height in pixels. If unknown: {@code null}.
     */
  public int getHeight() {
    return height;
  }

    /**
     * Get the source URL of the image.
     *
     * @return The source URL of the image.
     */
  public String getUrl() {
    return url;
  }

    /**
     * Get the width of the image in pixels.
     *
     * @return The image width in pixels. If unknown: {@code null}.
     */
  public int getWidth() {
    return width;
  }

  @Override
  public Builder builder() {
    return new Builder();
  }

    /**
     * Builder class for building {@link Image} instances.
     */
  public static final class Builder extends AbstractModelObject.Builder {
    private int height;
    private String url;
    private int width;

        /**
         * The height setter.
         *
         * @param height The image height in pixels. If unknown: {@code null}.
         * @return A {@link Image.Builder}.
         */
    public Builder setHeight(int height) {
      this.height = height;
      return this;
    }

        /**
         * The source URL setter.
         *
         * @param url The source URL of the image.
         * @return A {@link Image.Builder}.
         */
    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

        /**
         * The width setter.
         *
         * @param width The image width in pixels. If unknown: {@code null}.
         * @return A {@link Image.Builder}.
         */
    public Builder setWidth(int width) {
      this.width = width;
      return this;
    }

    @Override
    public Image build() {
      return new Image(this);
    }
  }

    /**
     * JsonUtil class for building {@link Image} instances.
     */
  public static final class JsonUtil extends AbstractModelObject.JsonUtil<Image> {
    public Image createModelObject(JsonObject jsonObject) {
      if (jsonObject == null || jsonObject.isJsonNull()) {
        return null;
      }

      return new Image.Builder()
              .setHeight((jsonObject.get("height") instanceof JsonNull) ? 0 : jsonObject.get("height").getAsInt())
              .setUrl(jsonObject.get("url").getAsString())
              .setWidth((jsonObject.get("width") instanceof JsonNull) ? 0 : jsonObject.get("width").getAsInt())
              .build();
    }
  }
}
