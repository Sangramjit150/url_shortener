import React, { useState } from "react";
import { useStoreContext } from "../../contextApi/ContextApi";
import { useForm } from "react-hook-form";
import TextField from "../TextField";
import { Tooltip } from "@mui/material";
import { RxCross2 } from "react-icons/rx";
import api from "../../api/api";
import toast from "react-hot-toast";

const CreateNewShorten = ({ setOpen, refetch }) => {
  const { token } = useStoreContext();
  const [loading, setLoading] = useState(false);

  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm({
    defaultValues: {
      originalUrl: "",
    },
    mode: "onTouched",
  });

const createShortUrlHandler = async (data) => {
  setLoading(true);

  try {
    const { data: res } = await api.post(
      "/api/urls/shorten",
      data,
      {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
          Authorization: "Bearer " + token,
        },
      }
    );

    const shortenUrl = `${
      import.meta.env.VITE_REACT_FRONT_END_URL
    }/s/${res.shortUrl}`;

    try {
      await navigator.clipboard.writeText(shortenUrl);

      toast.success("Short URL Copied to Clipboard", {
        position: "bottom-center",
        duration: 3000,
      });
    } catch (clipboardError) {
      console.log("Clipboard error:", clipboardError);
      toast.success("Short URL Created Successfully");
    }

    await refetch();

    reset();
    setOpen(false);
  } catch (error) {
    console.log(error);
    toast.error("Create ShortURL Failed");
  } finally {
    setLoading(false);
  }
};




  return (
    <div className="w-full flex items-center justify-center">
      <form
        onSubmit={handleSubmit(createShortUrlHandler)}
        className="relative w-full max-w-[450px] rounded-lg bg-white px-4 py-8 shadow-custom sm:px-8"
      >
        <h1 className="text-center font-montserrat text-[22px] font-bold text-slate-800 sm:text-2xl">
          Create New Shorten URL
        </h1>

        <hr className="mb-5 mt-2 text-slate-950" />

        <div>
          <TextField
            label="Enter URL"
            required
            id="originalUrl"
            placeholder="https://example.com"
            type="url"
            message="URL is required"
            register={register}
            errors={errors}
          />
        </div>

        <button
          type="submit"
          disabled={loading}
          className="my-3 w-32 rounded-md bg-gradient-to-r from-blue-500 to-purple-600 py-2 font-semibold text-white transition-opacity hover:opacity-90 disabled:cursor-not-allowed disabled:opacity-60"
        >
          {loading ? "Loading..." : "Create"}
        </button>

        {!loading && (
          <Tooltip title="Close">
            <button
              type="button"
              onClick={() => setOpen(false)}
              className="absolute right-2 top-2 rounded-full p-1 transition-colors hover:bg-slate-100"
            >
              <RxCross2 className="text-3xl text-slate-800" />
            </button>
          </Tooltip>
        )}
      </form>
    </div>
  );
};

export default CreateNewShorten;
