// Dependencias
const { Router } = require("express");

// Inicializaciones
const router = Router();

// Servicios
const customerService = require("../services/customer");

router.get("/", async (req, res) => {
    const { customers } = await customerService.getAll();
    res.render("customers", {
        results: customers
    });
});

router.post("/save", async (req, res) => {
    let newCustomer = {
        name: req.body.name,
        age: req.body.age,
        address: req.body.address
    };

    const customerInsert = await customerService.insert(newCustomer);
    console.log("Customer created successfully", customerInsert);
    res.redirect("/");
});

router.post("/update", async (req, res) => {
    const updateCustomer = {
        id: req.body.id,
        name: req.body.name,
        age: req.body.age,
        address: req.body.address
    };

    const customerUpdate = await customerService.update(updateCustomer);
    console.log("Customer updated successfully", customerUpdate);
    res.redirect("/");
});

router.post("/remove", async (req, res) => {
    await customerService.remove(req.body.customer_id);
    console.log("Customer removed successfully");
    res.redirect("/");
});

module.exports = router;