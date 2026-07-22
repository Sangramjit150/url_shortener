import React, { useState } from "react";
import { useForm } from "react-hook-form";
import TextField from "./TextField";
import { Link, useNavigate } from "react-router-dom";
import api from "../api/api";
import toast from "react-hot-toast";

const RegisterPage = () => {
  const navigate = useNavigate();
  const [loader, setLoader] = useState(false);

  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm({
    defaultValues: {
      username: "",
      email: "",
      password: "",
    },
    mode: "onTouched",
  });

  const registerHandler = async (data) => {
    setLoader(true);

    try {
      await api.post("/api/auth/public/register", data);

      reset();

      toast.success("Registration Successful!");

      navigate("/login");
    } catch (error) {
      console.log(error);
      toast.error("Registration Failed!");
    } finally {
      setLoader(false);
    }
  };

  return (
    <div className="min-h-[calc(100vh-64px)] flex justify-center items-center px-4">

      <form
        onSubmit={handleSubmit(registerHandler)}
        className="w-full max-w-[450px] shadow-custom py-8 sm:px-8 px-5 rounded-md"
      >

        <h1 className="text-center text-btnColor font-bold text-3xl">
          Register Here
        </h1>

        <hr className="mt-2 mb-5 border-slate-300" />

        <div className="flex flex-col gap-3">

          <TextField
            label="Username"
            required
            id="username"
            type="text"
            message="*Username is required"
            placeholder="Type your username"
            register={register}
            errors={errors}
          />

          <TextField
            label="Email"
            required
            id="email"
            type="email"
            message="*Email is required"
            placeholder="Type your email"
            register={register}
            errors={errors}
          />

          <TextField
            label="Password"
            required
            id="password"
            type="password"
            message="*Password is required"
            placeholder="Type your password"
            register={register}
            min={6}
            errors={errors}
          />

        </div>

        <button
          disabled={loader}
          type="submit"
          className="bg-gradient-to-r from-blue-500 to-purple-600 font-semibold text-white w-full py-2 hover:opacity-90 transition-opacity duration-200 rounded-sm my-3"
        >
          {loader ? "Loading..." : "Register"}
        </button>

        <p className="text-center text-sm text-slate-700 mt-6">
          Already have an account?

          <Link
            className="font-semibold underline hover:text-black"
            to="/login"
          >
            <span className="text-btnColor"> Login</span>
          </Link>
        </p>

      </form>

    </div>
  );
};

export default RegisterPage;
