import { useState } from "react";
import api from "../services/api";
import { toast } from "react-toastify";

export default function Register() {
  const [form, setForm] = useState({
    userName: "",
    userEmail: "",
    userPassword: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await api.post("/register", form);
      toast.success(res.data);
      setForm({ userName: "", userEmail: "", userPassword: "" });
    } catch (err) {
      toast.error(err.response?.data || "Registration failed");
    }
  };

  return (
    <div className="card">
      <h2>Create Account</h2>

      <form onSubmit={handleSubmit}>
        <input
          name="userName"
          placeholder="Full Name"
          value={form.userName}
          onChange={handleChange}
          required
        />

        <input
          name="userEmail"
          type="email"
          placeholder="Email"
          value={form.userEmail}
          onChange={handleChange}
          required
        />

        <input
          name="userPassword"
          type="password"
          placeholder="Password"
          value={form.userPassword}
          onChange={handleChange}
          required
        />

        <button type="submit">Register</button>
      </form>

      <p className="note">
        Check your email to verify your account.
      </p>
    </div>
  );
}
