# Generated by Django 4.0.4 on 2022-05-21 20:45

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('api', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='users',
            name='Email',
            field=models.CharField(max_length=50),
        ),
    ]
