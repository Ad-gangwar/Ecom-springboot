import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

const UpdateProduct = () => {
  const { id } = useParams();

  const [product, setProduct] = useState({});
  const [image, setImage] = useState(null);

  const [updateProduct, setUpdateProduct] = useState({
    id: null,
    name: "",
    desc: "",
    brand: "",
    price: 0,
    category: "",
    releaseDate: "",
    availability: false,
    stockQuantity: 0,
  });

  useEffect(() => {
    const fetchProduct = async () => {
      try {
        const res = await axios.get(
          `http://localhost:8080/api/products/${id}`
        );

        setProduct(res.data);
        setUpdateProduct(res.data);

        const imgRes = await axios.get(
          `http://localhost:8080/api/products/${id}/image`,
          { responseType: "blob" }
        );

        const imageFile = new File(
          [imgRes.data],
          res.data.imageName,
          { type: imgRes.data.type }
        );

        setImage(imageFile);
      } catch (error) {
        console.error("Error fetching product:", error);
      }
    };

    fetchProduct();
  }, [id]);

  const handleChange = (e) => {
    const { name, value } = e.target;

    setUpdateProduct({
      ...updateProduct,
      [name]:
        name === "price" || name === "stockQuantity"
          ? Number(value)
          : value,
    });
  };

  const handleImageChange = (e) => {
    setImage(e.target.files[0]);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("imageFile", image);
    formData.append(
      "product",
      new Blob([JSON.stringify(updateProduct)], {
        type: "application/json",
      })
    );

    try {
      await axios.put(
        `http://localhost:8080/api/products/${id}`,
        formData
      );
      alert("Product updated successfully!");
    } catch (error) {
      console.error("Update failed:", error);
      alert("Failed to update product");
    }
  };

  return (
    <div className="update-product-container">
      <div className="center-container">
        <h1>Update Product</h1>

        <form className="row g-3 pt-5" onSubmit={handleSubmit}>
          <div className="col-md-6">
            <label className="form-label"><h6>Name</h6></label>
            <input
              type="text"
              className="form-control"
              name="name"
              value={updateProduct.name}
              onChange={handleChange}
            />
          </div>

          <div className="col-md-6">
            <label className="form-label"><h6>Brand</h6></label>
            <input
              type="text"
              className="form-control"
              name="brand"
              value={updateProduct.brand}
              onChange={handleChange}
            />
          </div>

          <div className="col-12">
            <label className="form-label"><h6>Description</h6></label>
            <input
              type="text"
              className="form-control"
              name="desc"
              value={updateProduct.desc}
              onChange={handleChange}
            />
          </div>

          <div className="col-md-5">
            <label className="form-label"><h6>Price</h6></label>
            <input
              type="number"
              className="form-control"
              name="price"
              value={updateProduct.price}
              onChange={handleChange}
            />
          </div>

          <div className="col-md-6">
            <label className="form-label"><h6>Category</h6></label>
            <select
              className="form-select"
              name="category"
              value={updateProduct.category}
              onChange={handleChange}
            >
              <option value="">Select category</option>
              <option value="Laptop">Laptop</option>
              <option value="Headphone">Headphone</option>
              <option value="Mobile">Mobile</option>
              <option value="Electronics">Electronics</option>
              <option value="Toys">Toys</option>
              <option value="Fashion">Fashion</option>
            </select>
          </div>

          <div className="col-md-4">
            <label className="form-label"><h6>Stock Quantity</h6></label>
            <input
              type="number"
              className="form-control"
              name="stockQuantity"
              value={updateProduct.stockQuantity}
              onChange={handleChange}
            />
          </div>

          <div className="col-md-8">
            <label className="form-label"><h6>Image</h6></label>
            {image && (
              <img
                src={URL.createObjectURL(image)}
                alt="product"
                style={{
                  width: "100%",
                  height: "180px",
                  objectFit: "cover",
                }}
              />
            )}
            <input
              className="form-control"
              type="file"
              onChange={handleImageChange}
            />
          </div>

          <div className="col-12">
            <div className="form-check">
              <input
                className="form-check-input"
                type="checkbox"
                checked={updateProduct.availability}
                onChange={(e) =>
                  setUpdateProduct({
                    ...updateProduct,
                    availability: e.target.checked,
                  })
                }
              />
              <label className="form-check-label">
                Product Available
              </label>
            </div>
          </div>

          <div className="col-12">
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default UpdateProduct;
