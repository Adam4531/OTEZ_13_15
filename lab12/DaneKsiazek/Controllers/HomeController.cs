using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using DaneKsiazek.Models;

namespace DaneKsiazek.Controllers
{

    public class HomeController : Controller
    {
        private KsiazkiEntities _db = new KsiazkiEntities();
        //
        // GET: /Home/
        public ActionResult Index()
        {
            return View(_db.Ksiazki.ToList());
        }

        

        // GET: Home/Create
        public ActionResult Create()
        {
            return View();
        }
        // POST: /Home/Create
        [HttpPost]
        public ActionResult Create(Ksiazka newKsiazka)
        {
            if (ModelState.IsValid)
            {
                _db.Ksiazki.Add(newKsiazka);
                _db.SaveChanges();
                return RedirectToAction("Index");
            }
            else
            {
                return View(newKsiazka);
            }
        }

        // GET: Home/Details/5
        public ActionResult Details(int id)
        {
            var ksiazkaToDetails = (from ksiazka in _db.Ksiazki
                                    where ksiazka.ksiazkaId == id
                                    select ksiazka).First();
            return View(ksiazkaToDetails);
        }

        // GET: /Home/Edit/5
        public ActionResult Edit(int id)
        {
            var ksiazkaToEdit = (from Ksiazka in _db.Ksiazki
                                 where Ksiazka.ksiazkaId == id
                                 select Ksiazka).First();
            return View(ksiazkaToEdit);
        }

        //
        // POST: /Home/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Ksiazka ksiazkaToEdit)
        {
            if (ModelState.IsValid)
            {
                _db.Entry(ksiazkaToEdit).State = System.Data.Entity.EntityState.Modified;
                _db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(ksiazkaToEdit);
            
        }

        // GET: Home/Delete/5
        public ActionResult Delete(int id)
        {
            var ksiazkaToDelete = (from ksiazka in _db.Ksiazki
                                   where ksiazka.ksiazkaId == id
                                   select ksiazka).First();
            return View(ksiazkaToDelete);
        }
        //
        // POST: /Home/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, Models.Ksiazka ksiazkaToDelete)
        {
            var SelKsiazka = (from ksiazka in _db.Ksiazki
                              where ksiazka.ksiazkaId ==
                              id
                              select ksiazka).First();
            if (!ModelState.IsValid)
                return View(SelKsiazka);
            _db.Ksiazki.Remove(SelKsiazka);
            _db.SaveChanges();
            return RedirectToAction("Index");
       
        }

    }
}
