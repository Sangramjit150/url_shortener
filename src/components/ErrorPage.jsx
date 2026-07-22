import React from "react";
import { useNavigate } from "react-router-dom";
import { FaExclamationTriangle } from "react-icons/fa";

const ErrorPage = ({ message }) => {
  const navigate = useNavigate();

  return (
    <div className="flex min-h-[calc(100vh-64px)] flex-col items-center justify-center bg-gray-100 px-6 py-10 text-center">
      <FaExclamationTriangle className="mb-4 text-6xl text-red-500" />

      <h1 className="mb-2 text-3xl font-bold text-gray-800">
        Oops! Something went wrong.
      </h1>

      <p className="mb-6 max-w-md text-gray-600">
        {message || "An unexpected error has occurred."}
      </p>

      <button
        onClick={() => navigate("/")}
        className="rounded-md bg-[#3364F7] px-5 py-2 font-semibold text-white transition-colors duration-200 hover:bg-[#2854d9]"
      >
        Go Back to Home
      </button>
    </div>
  );
};

export default ErrorPage;
