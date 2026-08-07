/* ==================================================
   ESCOLAINFO WEB
   APP.JS - CONTROLE GERAL
================================================== */



document.addEventListener("DOMContentLoaded",()=>{


    const btnMenu = document.getElementById("btnMenu");

    const sidebar = document.getElementById("sidebar");



    /*
       ABRIR / FECHAR MENU
    */

    if(btnMenu){


        btnMenu.addEventListener("click",()=>{


            sidebar.classList.toggle("show");


        });


    }






    /*
       FECHAR MENU AO CLICAR FORA
       (MOBILE)
    */


    document.addEventListener("click",(e)=>{


        if(window.innerWidth <= 992){


            const clicouMenu = sidebar.contains(e.target);

            const clicouBotao = btnMenu.contains(e.target);



            if(!clicouMenu && !clicouBotao){


                sidebar.classList.remove("show");


            }


        }



    });






    /*
       MENU ATIVO AUTOMÁTICO
    */


    const paginaAtual =
    window.location.pathname.split("/").pop();



    const links =
    document.querySelectorAll(".menu");



    links.forEach(link=>{


        const destino =
        link.getAttribute("href");



        if(destino === paginaAtual){


            link.classList.add("active");


        }


    });



});