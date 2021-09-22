import React from 'react';
import Item from "../Item/Item";
import Cart from "../Cart/Cart";

const Home = (props) => {
  return(
     <div>
        <h1 className="text-center mt-3"> Available events</h1>
         <section className="py-4 container">
            <div className="row justify-content-center">
                {
                    props.items.map((item, index) => {
                        return(
                            <Item
                            imageSrc={item.imageSrc}
                            eventName = {item.eventName}
                            startTime = {item.startTime}
                            item={item}
                            />
                        )
                    })
                }
            </div>
             <Cart/>
         </section>
     </div>
  );
};

export default Home;