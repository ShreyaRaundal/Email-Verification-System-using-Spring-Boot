import { useState } from "react";
import Register from "./components/Register";
import Verify from "./components/Verify";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export default function App() {
  const [dark, setDark] = useState(false);

  const isVerifyPage = window.location.pathname.includes("confirm-account");

  return (
    <div className={dark ? "app dark" : "app"}>
      <button className="toggle" onClick={() => setDark(!dark)}>
        {dark ? "☀ Light" : "🌙 Dark"}
      </button>

      {isVerifyPage ? <Verify /> : <Register />}

      <ToastContainer position="top-center" />
    </div>
  );
}
