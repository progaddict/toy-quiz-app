(function () {
  const Counter = {
    data() {
      return {
        counter: 0,
      };
    },
  };

  const main = () => {
    console.log("main");
    Vue.createApp(Counter).mount("#counter");
  };

  document.addEventListener("DOMContentLoaded", (event) => {
    main();
  });
})();
