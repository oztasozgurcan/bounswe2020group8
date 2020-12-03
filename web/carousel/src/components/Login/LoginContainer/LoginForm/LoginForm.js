import { Form } from "antd";
import classes from "../../../UI/UI.module.css";
import ButtonPrimary from "../../../UI/ButtonPrimary/ButtonPrimary";

import React, { useState, useEffect, useContext, useRef } from "react";

import InputUI from "../../../UI/InputUI/InputUI";
import ButtonSecondary from "../../../UI/ButtonSecondary/ButtonSecondary";
import UserInfo from "../../../Context/UserInfo";
import GoogleAuth from "../../../GoogleAuth";

const LoginForm = (props) => {
  const [error, setError] = useState(false);
  const [visible, setVisible] = useState(false);

  const user = useContext(UserInfo);
  const isFirstRun = useRef(true);

  useEffect(() => {
    if (isFirstRun.current) {
      isFirstRun.current = false;
      user.setUserType("Customer");
      return;
    } else {
      if (user.error) {
        setVisible(true);
        setError(false);
      }

      return () => {
        setError(false);
      };
    }
  }, [user.error, error]);


  const eraseError = () => {
    setVisible(false);
  };


  return (
    <Form
      name="normal_login"
      className="login-form"
      initialValues={{ remember: true }}
      style={{
        height: "350px",
        margin: "auto",
        display: "grid",
        fontSize: "16px",
        paddingTop: "40px",
      }}
    >
      <p style={{marginTop:"-60px"}}>{user.userType === "Customer" ? "Customer Login" : "Vendor Login"}</p>
      {visible ? (
        <p
          style={{
            backgroundColor: "#ffb3b3",
            color: "darkred",
            margin: "auto",
            marginTop: "-20px",
            border: "1px solid darkred",
            width: "240px",
          }}
        >
          Invalid e-mail or password!
        </p>
      ) : (
        <p
          style={{
            backgroundColor: "#ffffff",
            color: "white",
            margin: "auto",
            marginTop: "-20px",
            border: "1px solid white",
            width: "240px",
          }}
        >
          .
        </p>
      )}
      <Form.Item name="username">
        <InputUI
          clicked={eraseError}
          name="email"
          iconSel="user"
          inputType="text"
          placeholder="E-mail"
        />
      </Form.Item>
      <Form.Item name="password">
        <InputUI
          name="password"
          clicked={eraseError}
          inputType="password"
          placeholder="Password"
          iconSel="locked"
        />
      </Form.Item>

      <Form.Item style={{ height: "30px" }}>
        <div
          className={classes.LinkText}
          onClick={props.forgot}
          style={{ paddingLeft: "164px" }}
        >
          Forgot password
        </div>
      </Form.Item>
      <Form.Item style={{ marginBottom: "-20px" }}>
        <ButtonPrimary
          style={{ width: "274px", fontSize: "16px" }}
          title={"LOGIN"}
          onClick={() => {
            setError(true);
            props.clicked();
            user.setUserType("Customer");
          }}
        ></ButtonPrimary>
        <br style={{ height: "10px" }} />
        <div style={{marginLeft:"10px"}}>
          {user.userType === "Customer" ? <GoogleAuth isSignup={false} style={{fontSize: "50px"}}/> : null}
        </div>
        <ButtonSecondary
          style={{ width: "274px", fontSize: "14px", textDecoration:"underline" }}
          title={user.userType === "Customer" ? "Login as Vendor" : "Login as Customer"}
          onClick={() => {
            setError(true);
            {
              user.userType === "Customer" ? user.setUserType("Vendor") : user.setUserType("Customer")
            }
          }}
        ></ButtonSecondary>
      </Form.Item>
    </Form>
  );
};

export default LoginForm;
