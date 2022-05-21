from xml.dom import xmlbuilder
from xml.sax import xmlreader
from django.http import JsonResponse
from django.shortcuts import render
from django.views import View
from .models import Users
from django.utils.decorators import method_decorator
from django.views.decorators.csrf import csrf_exempt
import json
# from rest_framework_xml.parsers import XMLParser
# from rest_framework_xml.renderers import XMLRenderer
# from rest_framework.response import Response
# from rest_framework.views import APIView


# Create your views here.
class UsersView(View):

    # renderer_classes = [XMLRenderer, ]

    @method_decorator(csrf_exempt)
    def dispatch(self, request, *args, **kwargs):
        return super().dispatch(request, *args, **kwargs)

    #Todos los usuarios o solo uno
    def get(self, request,id=0):
        #Solo un usuario
        if(id>0):
            users=list(Users.objects.filter(id=id).values())
            if len(users)>0:
                user=users[0]
                datos={'message':"Success", "users":user}
            else:
                 datos={'message':"User not found..."}
            return JsonResponse(datos)
        else:
            #Todos los usuarios
            users=list(Users.objects.values())
            if len(users)>0:
                datos={'message':"Success", "users":users}
                
            else:
                datos={'message':"Users not found..."}
            return JsonResponse(datos)
            

    #Colocar un usuario
    def post(self, request):
        jd=json.loads(request.body)
        Users.objects.create(Name=jd['Name'],Email=jd['Email'],Password=jd['Password'],Description=jd['Description'])
        datos={'message':"Success"}
        return JsonResponse(datos)


    # Actualizar usuario
    def put(self, request,id):
        jd = json.loads(request.body)
        users=list(Users.objects.filter(id=id).values())
        if len(users)>0:
            user=Users.objects.get(id=id)
            user.Name=jd['Name']
            user.Email=jd['Email']
            user.Password=jd['Password']
            user.Description=jd['Description']
            user.save()
            datos={'message':"Success"}

        else:
            datos={'message':"User not found..."}
        return JsonResponse(datos)


    # Borrar usuario
    def delete(self, request, id):
        users=list(Users.objects.filter(id=id).values())
        if len(users)>0:
            Users.objects.filter(id=id).delete()
            datos={'message':"Success"}
        else:
            datos={'message':"User not found..."}
        return JsonResponse(datos)




