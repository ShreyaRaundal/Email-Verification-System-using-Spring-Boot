import { useEffect } from "react";
import api from "../services/api";
import { toast } from "react-toastify";

export default function Verify() {
  useEffect(() => {
    const token = new URLSearchParams(window.location.search).get("token");

    if (!token) {
      toast.error("Invalid verification link");
      return;
    }

    api
      .get(`/confirm-account?token=${token}`)
      .then((res) => toast.success(res.data))
      .catch((err) =>
        toast.error(err.response?.data || "Verification failed")
      );
  }, []);

  return (
    <div className="card">
      <h2>Email Verification</h2>
      <p>Processing verification...</p>
    </div>
  );
}
