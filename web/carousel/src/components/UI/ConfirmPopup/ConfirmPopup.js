import "react-confirm-alert/src/react-confirm-alert.css";
import classes from "./ConfirmPopup.module.css";

import { confirmAlert } from "react-confirm-alert";
import ButtonPrimary from "../ButtonPrimary/ButtonPrimary";

const handleSubmit = (title, handleConfirm) => {
  confirmAlert({
    customUI: ({ onClose }) => {
      return (
        <div className={classes.Popup}>
          <h1>{title}</h1>
          <div className={classes.ButtonRow}>
            <ButtonPrimary
              onClick={() => {
                handleConfirm();
                onClose();
              }}
              title="Yes"
            />
            <ButtonPrimary onClick={onClose} title="No" />
          </div>
        </div>
      );
    },
  });
};

export default handleSubmit;
