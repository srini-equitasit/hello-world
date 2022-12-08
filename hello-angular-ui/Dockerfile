## stage 1
FROM node:14-alpine as build-step
RUN mkdir -p /app

WORKDIR /app
COPY . /app

#RUN pwd
#RUN ls -l

#RUN npm install --loglevel verbose
RUN npm install

RUN npm run build --prod


## stage 2
FROM nginx:1.22.1-alpine
COPY --from=build-step /app/dist/hello-angular-ui /usr/share/nginx/html

COPY default.conf.template /etc/nginx/templates/default.conf.template

EXPOSE 80



#EXPOSE 4200 49153
#EXPOSE 4200
#CMD npm start

#docker run -it 337901474843.dkr.ecr.us-east-1.amazonaws.com/equitas-it:emp-ui-app sh
