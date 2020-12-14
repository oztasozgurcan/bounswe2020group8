const constants = {
  NODE_ENV: "dev",
  CLIENT_ACTIVE_DURATION: 60000,
  ENUMS: {
    CLIENT_TYPE: {
      CUSTOMER: "Customer",
      VENDOR: "Vendor",
      ADMIN: "Admin",
    },
  },
  LANGUAGE: {
    EN: "en",
    TR: "tr",
  },
  RESPONSE: {
    CODE: "returnCode",
    MESSAGE: "returnMessage",
    TITLE: "returnTitle",
    ICON: "iconName",
  },
  DAYS: {
    en: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
  },
};

module.exports = constants;