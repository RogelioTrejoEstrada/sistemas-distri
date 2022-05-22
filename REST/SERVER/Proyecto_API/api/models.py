from pyexpat import model
from django.db import models

# Create your models here.
class Users(models.Model):
    Name=models.CharField(max_length=50)
    Email=models.CharField(max_length=50)
    Password=models.CharField(max_length=50)
    Description=models.CharField(max_length=100)
